# Spring Cloud Tutorials

Tutorials for learning Spring Cloud.

#### Compile
`$ mvn package`

#### Modules
- **tt01-config-native** - Configuration with native mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ java -jar tt01-config-native/tt01-config-native-server/target/tt01-config-native-server-1.0.0.jar`
        - `$ java -jar tt01-config-native/tt01-config-native-client/target/tt01-config-native-client-1.0.0.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt01.`

- **tt02-config-git** - Configuration with git mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ java -jar tt02-config-git/tt02-config-git-server/target/tt02-config-git-server-1.0.0.jar`
        - `$ java -jar tt02-config-git/tt02-config-git-client/target/tt02-config-git-client-1.0.0.jar`
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
        - `$ java -jar tt03-config-zookeeper/target/tt03-config-zookeeper-1.0.0.jar`
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
        - `$ java -jar tt04-config-consul/target/tt04-config-consul-1.0.0.jar`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt04.`
