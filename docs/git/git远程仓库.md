### 本地仓库与远程仓库

- 关联远程仓库：

  1. 为远程仓库设置别名

     `$ git remote add origin git@name.git`

  2. 本地仓库`推送`远程仓库

     `$ git push origin master`

  3. 本地仓库`拉取`远程仓库

     - **`git pull`**

       存在本地仓库，将远程仓库新的commit数据下拉到本地，并与本地代码merge

       `$ git pull origin master`

     - **`git clone`**

       没有本地仓库，将远程仓库整个下载过来

       `$ git clone git@gitskills.git`

- 取消关联远程仓库：

  `$ git remote remove origin`