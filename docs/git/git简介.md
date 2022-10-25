### git简介

- git配置

    标注哪个用户在进行git操作，用于分布式版本控制系统内进行识别。
    
    ```c
    $ git config --global user.name "Your Name"
    $ git config --global user.email "email@example.com"
    ```

- 创建版本库

  文件夹内的文件都能被git管理起来，每个文件改变，都能跟踪，便于未来某个时刻可以操作处理。

  ```c
  $ mkdir learngit
  $ cd learngit
  $ git init
  ```

- 常用命令

    - 查看状态

      `$ git status`

    - 查看内容

      `$ cat readme.txt`

    - 查看变化

      `$ git diff readme.txt`
