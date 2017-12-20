# Spring Cloud Tutorials

Tutorials for learning Spring Cloud.

#### Compile
`$ mvn clean package`

#### Modules
- **tt01-config-native** - Configuration with native mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ java -jar tt01*/*server/target/*.jar`
        - `$ java -jar tt01*/*client/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt01.`

- **tt02-config-git** - Configuration with git mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ java -jar tt02*/*server/target/*.jar`
        - `$ java -jar tt02*/*client/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt02.`
 
- **tt03-config-zookeeper** - Configuration with [Spring Cloud Zookeeper](http://cloud.spring.io/spring-cloud-zookeeper/)
    - Install and start [Zookeeper](http://zookeeper.apache.org/). If using [Homebrew](https://brew.sh/) on Mac:
        - `$ brew install zookeeper`
        - `$ zkServer start`
        > Now a local zookeeper is running at `localhost:2181`.
    - Create configurations in zookeeper:
        - `$ zkCli`
        - `zk$ create /config ''`
        - `zk$ create /config/tt03-hello ''`
        - `zk$ create /config/tt03-hello/server ''`
        - `zk$ create /config/tt03-hello/server/port 8080`
        - `zk$ create /config/tt03-hello/hello ''`
        - `zk$ create /config/tt03-hello/hello/message "Hello, I'm tt03."`
    - Run
        - `$ java -jar tt03*/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt03.`

- **tt04-config-consul** - Configuration with [Spring Cloud Consul](http://cloud.spring.io/spring-cloud-consul/)
    - Install and start [Consul](https://www.consul.io). If using [Homebrew](https://brew.sh/) on Mac:
        - `$ brew install consul`
        - `$ consul agent -dev -advertise 127.0.0.1`
        > Now a consul agent is running at `localhost:8500`.
    - Create configurations in consul:
        - `$ consul kv put config/tt04-hello/server/port 8080`
        - `$ consul kv put config/tt04-hello/hello/message "Hello, I'm tt04."`
    - Run
        - `$ java -jar tt04*/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt04.`
 
- **tt11-eureka-standalone** - Standalone mode of [Spring Cloud Netflix Eureka](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt11*/*server/target/*.jar`
        - `$ java -jar tt11*/*client/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print out instance info.
        - Open `http://localhost:8761` in browser to check eureka portal.
        - Open `http://localhost:8761/eureka/apps` in browser to check registered services.
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
 
- **tt12-eureka-ha** - HA mode of [Spring Cloud Netflix Eureka](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt12*/*server/target/*.jar --spring.profiles.active=peer1`
        - `$ java -jar tt12*/*server/target/*.jar --spring.profiles.active=peer2`
        - `$ java -jar tt12*/*client/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print out instance info.
        - Open `http://localhost:8761` or `http://localhost:8762` in browser to check eureka portal.
        - Open `http://localhost:8761/eureka/apps` in browser to check registered services.
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
 
- **tt13-eureka-config** - Register config server to [Spring Cloud Netflix Eureka](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt13*/*eureka-server/target/*.jar`
        - `$ java -jar tt13*/*config-server/target/*.jar`
        - `$ java -jar tt13*/*config-client/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt13.`
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
 
- **tt21-hystrix** - Simple usage of [Spring Cloud Netflix Hystrix](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt21*/target/*.jar`
    - Verify
        - `$ curl http://localhost:8080/hello?name=abc` should print `Hello ABC!`.
        - `$ curl http://localhost:8080/hello?name=a` should print `Hello A [FALLBACK]!`.
 
- **tt22-hystrix-timeout** - Timeout of [Spring Cloud Netflix Hystrix](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt22*/*api/target/*.jar`
        - `$ java -jar tt22*/*consumer/target/*.jar`
    - Verify
        - Repeat the following `curl` and `CONSUMER [FALLBACK]` should be printed out randomly.
            - `$ curl http://localhost:8081/consume`
 
- **tt23-hystrix-dashboard** - Dashboard of [Spring Cloud Netflix Hystrix](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt23*/*server/target/*.jar`
        - `$ java -jar tt23*/*client/target/*.jar`
    - Verify
        - Open `http://localhost:8081/hystrix` in browser and you will see the dashboard.
          Input `http://localhost:8080/hystrix.stream` and click `Monitor Stream` button.
        - Do the following two `curl` randomly and watch the changes on dashboard.
            - `$ curl http://localhost:8080/hello?name=abc`
            - `$ curl http://localhost:8080/hello?name=a`
 
- **tt31-ribbon-resttemplate** - RestTemplate and [Spring Cloud Netflix Ribbon](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt31*/*api/target/*.jar --server.port=8081 --hello.id=server-1`
        - `$ java -jar tt31*/*api/target/*.jar --server.port=8082 --hello.id=server-2`
        - `$ java -jar tt31*/*consumer/target/*.jar`
    - Verify
        - Repeat the following `curl` and `server-1`, `server-2` should say hello by turns.
            - `$ curl http://localhost:8080/consume`
 
- **tt32-ribbon-eureka** - [Spring Cloud Netflix Ribbon](http://cloud.spring.io/spring-cloud-netflix/) with Eureka
    - Run
        - `$ java -jar tt11*/*server/target/*.jar`
        - `$ java -jar tt32*/*api/target/*.jar --server.port=8081 --hello.id=server-1`
        - `$ java -jar tt32*/*api/target/*.jar --server.port=8082 --hello.id=server-2`
        - `$ java -jar tt32*/*consumer/target/*.jar`
    - Verify
        - Repeat the following `curl` and `server-1`, `server-2` should say hello by turns.
            - `$ curl http://localhost:8080/consume`
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
 
- **tt41-feign** - Simple usage of [Spring Cloud Netflix Feign](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt41*/*api/target/*.jar --server.port=8081 --hello.id=server-1`
        - `$ java -jar tt41*/*api/target/*.jar --server.port=8082 --hello.id=server-2`
        - `$ java -jar tt41*/*consumer/target/*.jar`
    - Verify
        - Repeat the following `curl` and `server-1`, `server-2` should say hello by turns.
            - `$ curl http://localhost:8080/consume`
 
- **tt42-feign-hystrix-eureka** - [Spring Cloud Netflix Feign](http://cloud.spring.io/spring-cloud-netflix/) with Hystrix, Eureka
    - Run
        - `$ java -jar tt11*/*server/target/*.jar`
        - `$ java -jar tt42*/*api/target/*.jar --server.port=8081 --hello.id=server-1`
        - `$ java -jar tt42*/*api/target/*.jar --server.port=8082 --hello.id=server-2`
        - `$ java -jar tt42*/*consumer/target/*.jar`
    - Verify
        - Repeat the following `curl` and hystrix fallback should be triggered randomly.
            - `$ curl http://localhost:8080/consume`
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
 
- **tt51-turbine** - [Spring Cloud Netflix Turbine](http://cloud.spring.io/spring-cloud-netflix/)
    - Run
        - `$ java -jar tt11*/*server/target/*.jar`
        - `$ java -jar tt51*/*api-1/target/*.jar --server.port=8081 --hello.id=server-1`
        - `$ java -jar tt51*/*api-1/target/*.jar --server.port=8082 --hello.id=server-2`
        - `$ java -jar tt51*/*api-2/target/*.jar --server.port=8083 --hello.id=server-3`
        - `$ java -jar tt51*/*api-2/target/*.jar --server.port=8084 --hello.id=server-4`
        - `$ java -jar tt51*/*server/target/*.jar`
        - `$ java -jar tt23*/*server/target/*.jar --server.port=9090`
    - Verify
        - Open `http://localhost:9090/hystrix` in browser and you will see the dashboard.
          Input `http://localhost:8080/turbine.stream` and click `Monitor Stream` button.
        - Do the following two `curl` randomly and watch the changes on dashboard.
            - `$ curl http://localhost:8081/consume`
            - `$ curl http://localhost:8082/consume`
            - `$ curl http://localhost:8083/consume`
            - `$ curl http://localhost:8084/consume`
    > It takes one or two minutes for Eureka to take effect. You should wait this time to do the verify.
