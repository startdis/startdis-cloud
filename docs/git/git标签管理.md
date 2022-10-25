### 标签管理

> 每次commit的文件有对应的版本号，但是版本号不易记录，因此，需要一个标签（tag），指向某个commit，
> 这个标签默认指向最新提交的commit上的。

- 创建标签

  1. 查看所有标签

     `$ git tag`

  2. 新建标签（默认为HEAD）

     `$ git tag <tagname>`

     `示例：` `$ git tag v1.0`

  3. 新建标签（指定一个commit id）

     `$ git tag <tagname> <commit id>`

     `示例：` `$ git tag v1.2 6a5819e...`

  4. 指定标签信息

     `$ git tag -a <tagname> -m "blablabla..."`

     `$ git tag -a v1.0 -m "测试版本1.0"`

- 操作标签

  1. 推送一个本地标签

     `$ git push origin <tagname>`

  2. 推送全部未推送过的本地标签

     `$ git push origin --tags`

  3. 删除一个本地标签

     `$ git tag -d <tagname>`

  4. 删除一个远程标签

     `$ git push origin :refs/tags/<tagname>`