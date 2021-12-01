The purpose of this small test program is to validate scredis behavior when the DNS entry of a redis host changed
and scredis attemps to reconnect to the Scredis host.

Scredis does not seem to re-resolve the host name:

To validate this behavior start redis:

    docker compose up redis -d

Then build and start the test program:

    sbt docker:publishLocal ; docker-compose run redis-test

Change the ip address assigned to redis in the docker compose file, and than restart the redis container.

    docker compose down redis
    docker compose up redis

The test program should connect to the new IP address, however continues to connect to the old test program.

The behavior should be fixed with this [PR](https://github.com/scredis/scredis/pull/204)


