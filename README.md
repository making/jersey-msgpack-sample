## JAX-RS(Jersey) + MessagePack sample

### Run

``` bash
$ mvn spring-boot:run
```

``` bash
$ curl -v -H "Accept: application/x-msgpack" "localhost:8080/calc?left=100&right=300"
> GET /calc?left=100&right=300 HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: application/x-msgpack
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/x-msgpack;charset=UTF-8
< Content-Length: 26
< Date: Fri, 16 Jan 2015 16:32:05 GMT
<
��leftd�right�,�answer��s
```

Content negotiation is supported.

``` bash
$ curl -v -H "Accept: application/json" "localhost:8080/calc?left=100&right=300"
> GET /calc?left=100&right=300 HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: application/json
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Content-Type: application/json;charset=UTF-8
< Content-Length: 37
< Date: Fri, 16 Jan 2015 16:32:52 GMT
<
{"left":100,"right":300,"answer":400}
```

### Test

``` bash
$ mvn test
```

### Create executable jar

``` bash
$ mvn package
$ java -jar target/jersey-msgpack-sample-*.jar
```