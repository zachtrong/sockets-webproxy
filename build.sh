rm -rf build && mkdir build
mvn clean install
mvn javafx:jlink -pl :sockets-webproxy-client
cp sockets-webproxy-server/target/*-jar-with-dependencies.jar build/
cp sockets-webproxy-client/target/*.zip build/
