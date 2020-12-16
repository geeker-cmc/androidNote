# SQLite

> SQLite是一个进程内的库，无服务器的、零配置的、事务性的SQL数据库引擎。

## 存储类型

|存储类|描述|
|:--:|:--:|
|NULL|NULL值|
|INTEGER|值是带符号的整数，根据值的大小存储在1、2、3、4、6、或8字节中。|
|REAL|浮点值，存储为8字节的IFEE浮点数字|
|TEXT|字符串文本，使用数据库编码（UTF-8、UTF-16BE或UTF-16LE）存储|
|BLOB|blob数据，根据它的输入存储|

## 创建表及主键

```java

create table Book(id integer primary key autoincrement)

```

## android使用SQLite
> 在Android中使用SQLite需要借助几个类

* SQLiteOpenHelper

> 继承该类，并在onCreate生命周期执行create语句建表。并在实例化该类的子类时，传入上下文及库名。该实例化对象有两个方法`getWritableDatabase`和`getReadableDatabase`返回一个`SQLiteDatabase`的对象。该对象的api可以对数据库做CRUP。

* ContentValues
> 该类的实例化对象作为插入到表里的数据

* Cursor
> 调用SQLiteDatabase实例的query方法返回一个游标，通过这个对象可以访问表里面的数据。
