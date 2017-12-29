FROM ubuntu

WORKDIR "/root"
RUN apt-get update && apt-get install -y wget
RUN apt-get update && apt-get install -y default-jdk
RUN wget https://github.com/bucknercd/CommsCalculator/raw/master/CommsCalc.jar



RUN chmod 755 CommsCalc.jar
RUN ls -alh

RUN java -version

CMD java -jar CommsCalc.jar
