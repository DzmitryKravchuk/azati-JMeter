FROM openjdk:8-jre-slim

RUN mkdir /jmeter \
    && cd /jmeter/ \
    && apt-get update \
    && apt-get install wget -y \
    && wget https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-5.5.tgz \
    && tar -xvzf apache-jmeter-5.5.tgz \
    && rm apache-jmeter-5.5.tgz

ENV JMETER_HOME /jmeter/apache-jmeter-5.5/

# Add Jmeter to the Path
ENV PATH $JMETER_HOME/bin:$PATH
