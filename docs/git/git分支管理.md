### 分支管理

> `master`指向提交，`head`指向当前分支，只有主分支的情况下，`head`指向`master`

- 创建与合并分支

  1. 初始状态，只有一个`master`分支。

     ![dev01](./images/dev01.png)

  2. 创建一个分支`dev`，此时`head`指向`dev`。

     ![dev02](./images/dev02.png)

  3. 对工作区修改提交，`dev`指针移动，`master`指针不变。

     ![dev03](./images/dev03.png)

  4. `dev`合并到`master`，`master`指向`dev`的当前提交，完成合并。

     ![dev04](./images/dev04.png)

  5. 删除`dev`分支，即把`dev`指针给删掉，只保留一条`master`分支。

     ![dev05](./images/dev05.png)

- 操作命令

  1. 查看分支

     `$ git branch`

  2. 创建分支

     `$ git branch <name>`

  3. 切换分支

     `$ git checkout <name>或者$ git switch <name>`

  4. 创建+切换分支

     `$ git checkout -b <name>或者$ git switch -c <name>`

  5. 合并某分支到当前分支

     `$ git merge <name>或者$ git merge --no-ff -m '普通合并，能看出合并历史'`

  6. 删除分支

     `$ git branch -d <name>`

- 解决冲突

  1. 查找出现冲突的文件

     `$ git status`

  2. 查看出现冲突的文件

     `$ cat readme.txt`

  3. git标记不同分支的内容，修改冲突，保存提交

     `$ git add readme.txt `

     `$ git commit -m "conflict fixed"`

  4. 查看合并

     `$ git log --graph --pretty=oneline --abbrev-commit`

  5. 删除分支

     `$ git branch -d <devname>`

- 分支管理策略

  1. 默认合并分支采用`Fast forward`模式，删除分支，丢失分支信息。

  2. `--no-ff`方式会在merge时生成一个新的commit，保留分支历史。

     `$ git merge --no-ff -m "merge with no-ff" dev`

     `$ git log --graph --pretty=oneline --abbrev-commit`

     ![dev06](.\images\dev06.png)

  3. 分支策略
     1. `master`分支是稳定的，仅用来发布新版本
     2. `dev`分支是不稳定的，是开发时接触的分支
     3. 每个人拥有自己的分支，并不时的向`dev`上合并
     
  ![dev07](.\images\dev07.png)