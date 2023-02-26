#!/bin/bash

COUNT=${1-1}

docker build -t jmeter-base jmeter-base
docker-compose build && docker-compose up -d --scale jmeter-master=1 && docker-compose up -d --scale jmeter-slave=$COUNT

SLAVE_IP=$(docker inspect -f '{{.Name}} {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -aq) | grep slave | awk -F' ' '{print $2}' | tr '\n' ',' | sed 's/.$//')

#WDIR=`docker exec -it master /bin/pwd | tr -d '\r'`
#It's better to get dir path as var name from docker, but running on Win had to hardcode
WDIR="/jmeter/apache-jmeter-5.5"
mkdir -p results
for filename in scripts/*.jmx; do
    NAME=$(basename $filename)
    NAME="${NAME%.*}"
    eval "docker cp $filename jmeter-master:$WDIR/scripts/"

    #eval "docker exec -it master /bin/bash -c 'mkdir $NAME && cd $NAME && ../bin/jmeter -n -t ../$filename -R$SLAVE_IP'"
    #While running on Win under GitBash had to remove '-it' and mirror start of file path: '//bin/bash'
    eval "docker exec jmeter-master //bin/bash -c 'mkdir $NAME && cd $NAME && ../bin/jmeter -n -t ../$filename -R$SLAVE_IP -Jserver.rmi.ssl.disable=true'"
    eval "docker cp jmeter-master:$WDIR/$NAME results/"
done

docker-compose stop && docker-compose rm -f