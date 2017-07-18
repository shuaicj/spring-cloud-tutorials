# Spring Cloud Tutorials

Tutorials for learning Spring Cloud.

#### Modules
> Note: All terminal commands are assuming that you are in the project top directory.
- **tt01-config-native** - Configuration with native mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ cd tt01-config-native/tt01-config-native-server && mvn spring-boot:run`
        - `$ cd tt01-config-native/tt01-config-native-client && mvn spring-boot:run`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt01!`

- **tt02-config-git** - Configuration with git mode of [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/)
    - Run
        - `$ cd tt02-config-git/tt02-config-git-server && mvn spring-boot:run`
        - `$ cd tt02-config-git/tt02-config-git-client && mvn spring-boot:run`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt02!`
 
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
        - `zk$ create /config/tt03-hello/hello/message "Hello, I'm tt03!"`
    - Run
        - `$ cd tt03-config-zookeeper && mvn spring-boot:run`
    - Verify
        - `$ curl http://localhost:8080/hello` should print `port: 8080, message: Hello, I'm tt03!`

