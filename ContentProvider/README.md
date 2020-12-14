# 获取手机联系人

1. 在清单里面添加读取联系人权限`android.permission.READ_CONTACTS`；
2. 动态申请权限；
3. 通过getContentResolver()，获取操作数据库的对象；
4. 通过resolver中的query获取cursor；
5. 调用moveToNext移动游标；
6. 调用cursor上的方法获取对应的值；