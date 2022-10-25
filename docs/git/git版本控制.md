### 版本控制

- 工作区和版本库
  - 工作区（working directory）
  
    本地初始化的目录，比如刚创建的`learngit`文件夹就是一个工作区

  ![working directory](.\images\working.png)

  - 版本库（repository）
  
    工作区内的隐藏目录`.git`，这个属于git的版本库，内容包括：
  
    1. stage（或者叫index）的暂存区
    
    2. 自动创建的第一个分支`master`
    
    3. 指向`master`的一个指针叫`HEAD`

  ![repository](.\images\repository.jpg)
  
- 文件添加到版本库

  第一步是用`git add`把文件添加进去，实际上就是把文件修改添加到暂存区；

  第二步是用`git commit`提交更改，实际上就是把暂存区的所有内容提交到当前分支。

  ```
  $ git add readme.txt
  $ git commit -m 'wrote a readme file'
  ```

- 版本回退

  1. git log查看提交日志

     ```
     $ git log
     $ git log --pretty=online
     ```

  2. 回退到指定版本

     ```
     $ git reset --hard HEAD^ (HEAD^^、HEAD~100)
     $ git reset --hard 1094a
     ```

  3. 查看历史命令

     `$ git reflog`

- 撤销修改

  1. 修改了工作区，想要丢弃修改

     `$ git checkout --file `

  2. 修改了工作区，并提交了暂存区，想要丢弃修改

     `$ git reset head <file>`

     `$ git checkout --file `

  3. 提交了暂存区，并提交了到版本库，想要丢弃修改

     `$ git reset --hard HEAD^`

- 删除文件

  1. 从版本库删除此文件

     ```
     $ git rm test.txt
     $ git commit -m "remove test.txt"
     ```

  2. 恢复误删的文件

     `$ git checkout -- test.txt`
