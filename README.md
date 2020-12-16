# android学习记录

## Content Provider

> 实际上是对数据库的CRUD，应用层面是ContentResolver的操作。通过匹配Uri来做相应的操作

* 匹配整个表的type
> vnd.android.cursor.dir/vnd.com.example.app.provider.table

* 匹配表里某行数据
> vnd.android.cursor.item/vnd.com.example.app.provider.table

* [案例获取手机上的联系人](https://github.com/geeker-cmc/androidNote/tree/master/ContentProvider)

## SQLite

* [创建数据库并做CRUD](https://github.com/geeker-cmc/androidNote/tree/master/SQLite)

