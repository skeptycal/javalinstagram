package javalinstagram.dbutil

import javalinstagram.hikari

// database-setup/reset
fun main(args: Array<String>) {

    hikari.connection.use { connection ->
        connection.createStatement().apply {
            executeUpdate("drop table if exists user")
            executeUpdate("create table user (id string, password string, created timestamp DEFAULT CURRENT_TIMESTAMP)")
            executeUpdate("drop table if exists photo")
            executeUpdate("create table photo (id string, ownerid string, created timestamp DEFAULT CURRENT_TIMESTAMP)")
            executeUpdate("drop table if exists like")
            executeUpdate("create table like (photoid string, ownerid string)")
        }
    }

}
