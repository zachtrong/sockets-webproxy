# sockets-webproxy

## Workflow
![Service Integration - Sockets Web Proxy](https://user-images.githubusercontent.com/17959734/135751556-e96b2df2-ce79-462e-8924-3c8a0e99d513.png)
*Figure 1*. Sockets webproxy workflow

## Requirements
Java 11: https://www.azul.com/downloads/?version=java-11-lts&os=windows&package=jdk  
Maven: https://maven.apache.org/

## Build
Navigate to sockets-webproxy directory and perform build script

`./build.sh`

Build output  
![Screen Shot 2021-10-04 at 10 32 35](https://user-images.githubusercontent.com/17959734/135788950-370147ff-cbb2-4d3f-9b03-776fdd876d3b.png)

![Screen Shot 2021-10-04 at 10 33 39](https://user-images.githubusercontent.com/17959734/135788978-1465fd0f-d294-4fb3-b12f-8a589a53bd4e.png)

![Screen Shot 2021-10-04 at 10 35 11](https://user-images.githubusercontent.com/17959734/135789074-b0a1f49a-d36c-4c07-a421-792fd523fe3c.png)  

## Setup

### Server application

Deploy .jar file to the target server as webproxy
Execute the following command on the server

`java -jar sockets-webproxy-server-1.0-SNAPSHOT-jar-with-dependencies.jar`

![Screen Shot 2021-10-04 at 10 36 25](https://user-images.githubusercontent.com/17959734/135789176-8a614c00-2ea6-4847-9d9f-b28dd65f9525.png)

### Client application

Client unzip the `socketswebproxyzip.zip` then execute `socketswebproxy` script under `bin` directory

```
unzip socketswebproxyzip.zip -d socketswebproxy
./socketswebproxy/bin/socketswebproxy
```

![Single Client](https://user-images.githubusercontent.com/17959734/135790683-66abe252-3d9a-4b2d-b6d6-1ce96aaf7a46.png)
*Figure 2*. Single client connect to the remote server and surf medium website

![Multiple Clients](https://user-images.githubusercontent.com/17959734/135790686-7ca5f74e-b085-4cd5-96ef-81a796ad1815.png)
*Figure 3*. Multiple clients connect to the same remote server then surf its own website
