# kodb

A simple object mapper for Kotlin, inspired from [dapper-dot-net](https://github.com/StackExchange/dapper-dot-net).

Caution: This library is not released yet. There is a possibility that API is changed.

# Getting Started

## build.gradle

```groovy
apply plugin: 'kotlin'

buildscript {
    ext.kotlin_version = '1.0.0'
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}
repositories {
    mavenCentral()
    maven { url 'http://oss.sonatype.org/content/repositories/snapshots' }
}
dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    compile 'com.github.rabitarochan:kodb:0.1-SNAPSHOT'
}
```

## Example

kodb is designed very simply. Please see the following example.

### Create Session

`Session` object is wrapper in java.sql.Connection to use API in kodb.

```kotlin
import com.github.rabitarochan.kodb.Session

val connection: java.sql.Connection = /* ... */
val session = Session(connection)
```

### Select Query

You can get list of data class in executed sql.

API definition:

```kotlin
inline def <reified T: Any> query(sql: String, params: Array<Any>? = null): List<T>
```

Usage:

```kotlin
data class Person(val id: Long, val name: String, val age: Int)

val session = Session(connection)

val persons: List<Person> = session.query<Person>("select * from person where age < ?", arrayOf(20))
```

When a result is 1 record, you can acquire 1 result of data class.

API definition:

```kotlin
inline def <reified T: Any> queryOne(sql: String, params: Array<Any>? = null): T?
```

Usage:

```kotlin
data class Person(val id: Long, val name: String, val age: Int)

val session = Session(connection)

val persons: Person? = session.queryOne<Person>("select * from person where id = ?", arrayOf(123))
```

A mapping is usually done automatically, but it's possible to define it by myself.

```kotlin
def <T: Any> queryRaw(sql: String, params: Array<Any>? = null, extract: (ResultSet) -> T): List<T>
```

Usage:

```kotlin
data class Person(val id: Long, val name: String, val age: Int)

val session = Session(connection)

val persons: List<Person> = session.queryRaw("select * from person where age < ?", arrayOf(20)) {
    // it: ResultSet
    return Person(it.getLong("id"), it.getString("name"), it.getInt("age"))
}
```

### Update operation

API definition:

```kotlin
fun update(sql: String, params: Array<Any>? = null): Int
```

Usage:

```kotlin
val count: Int = session.update(
        "insert into person (id, name, age) values (?, ?, ?)",
        arrayOf(111, "Alice", 17)
)
```

### Execute SQL

API definition:

```kotlin
fun execute(sql: String, params: Array<Any>? = null): Boolean
```

Usage:

```kotlin
val result: Boolean = session.execute("""
        create table person (
            id   serial  primary key,
            name varchar not null,
            age  int     not null
        )
""")
```

## TODO

* Transaction support
* Multiple query support
* Batch update support
* Large result set support (similar forEach)

## License

The MIT License

Copyright (c) 2016 - Kengo Asamizu
