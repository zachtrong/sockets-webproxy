rm -rf build && mkdir build
mvn clean install
mvn javafx:jlink -pl :sockets-webproxy-client
cp sockets-webproxy-common/target/*.jar build/
cp sockets-webproxy-server/target/*.jar build/
cp sockets-webproxy-client/target/*.zip build/
