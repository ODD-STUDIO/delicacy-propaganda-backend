# 美食宣传项目后端工程开发手册
## 1. 开发须知
- 安装 git 环境
- IDEA 下载 `lombok` 插件
- 本地建数据库 `delicacy`，统一表中主键名为 `id`，创建时间名为 `create_time`，更新时间名为 `update_time`，逻辑删除字段名为 `is_deleted`，不一致请更改
## 2. 快速开发
- 请修改 `odd-web` 模块下的 src/main/resources/jdbc-dev.properties，将数据库连接名和密码修改为本地相关。
- 本项目分为生产环境和开发环境，默认为开发环境(dev)，连接本地数据库；生产环境连接阿里云服务器数据库。
- 切换开发环境：修改 `odd-web` 模块下的 src/main/web/WEB-INF/web.xml，将 <param-value>dev</param-value> 修改为 prod。
## 3. 项目架构
本项目采用经典三层架构：即自上而下分别为：用户界面层(odd-web)，业务逻辑层(odd-service)，数据访问层(odd-dao)。
## 4. 模块介绍
### 1. commons
#### api 包
主要提供 rest 接口响应基本结构(ResponseBean)以及基本响应码
```
{
  "cood": 200,
  "msg": "响应成功",
  "data": null,
  "timestamp": 1625048687337 // 时间戳，有可能会有验证时间的需求
}
```
#### base 包
主要提供实体类、Mapper类、Service类的基类，提高代码复用性。
- BaseEntity<T>：要求所有实体类必须继承此类，无需再定义 `id`, `create_time`, `update_time`, `is_deleted` 这些公共字段。例如:
  - ```java
      public class Entity extends BaseEntity<Entity> {
        ......
      }
    ```
- BaseMapper<T>：要求所有 Mapper 必须继承此接口，请仔细阅读该接口方法及注释，该接口定义了大量基础 CRUD 操作，若有同等需求操作，请直接实现接口中的方法，不必定义，若有复杂需求，则再单独写方法。例如：
  - ```java
      public interface EntityMapper extend BaseMapper<Entity> {
        
        @Override
        int insert(Entity entity);
        
        @Override
        int update(Entity entity);
        
        ...
      }
    ```
- BaseService<M extends BaseMapper<T>, T extends BaseEntity<T>>：要求所有 Service 必须继承此抽象类，不必再像传统项目编写 xxxServiceImpl、xxxService...等代码。该抽象类提供了大量基础 CRUD 业务方法，若有同等需求操作，不必重写方法，若有复杂需求，则再单独写方法。例如：
  - ```java
      public class EntityService extend BaseService<EntityMapper, Entity> {
        // 现在该类已经具有大量操作的能力，无需实现任何代码，若有特殊需求请再单独写业务方法。
      }
    ```
#### exception 包
主要提供全局异常处理、定义了 `BusinessException` 业务异常基类，无特殊操作，可以阅读了解。
#### util 包
主要提供工具类，如 LogUtil、PageUtil 等。
- PageUtil：Mybatis 分页查询可以使用插件 PageHelper，此项目已经引入。PageUtil 主要用于构建 PageHelper 分页对象(PageInfo<>)，例如：
  ```java
   PageInfo<Entity> pageInfo = PageUtil.pageInfo(pageNum, pageSize);
  ```
  分页对象 pageInfo 主要由 Controller 层构建，然后直接传入 findPage(pageInfo, entity) 方法，该方法已经在 BaseService 中定义并实现，无需管多余操作，可以参考 `Good` 相关业务代码。
#### vo 包
主要定义一些 VO 类，用于返回前端渲染。目前只定义了 PageVO，由于 PageHelper 分页插件的对象 PageInfo 中包含字段太冗杂，考虑到前端无需过多字段，于是在 BaseService 中的 findPage 方法中，将 Controller 层传入的 PageInfo 对象转换成了 PgeVO 对象并返回，所以 Controller 接口返回属性应该是 `ResponseBean<PageVO<Entity>>`

### 2. odd-bean
主要存放实体类，参考 `Good`，请先新建一个包，再在包内建立相关你负责的模块的实体类。Bean 层相关开发规范上文已叙述，请仔细阅读 base 包内容！

### 3. odd-dao
主要存放 Mapper 类，参考 `GoodMapper`， 请先新建一个包，再在包内建立相关你负责的模块的 Mapper。 Dao 层相关开发规范上文已叙述，请仔细阅读 base 包内容！
**xxxMapper.xml 请写在 odd-web 模块中的 src/main/resources/mapper/ 目录下** 

### 4. odd-service
主要存放 Service 类，参考 `GoodService`，请先新建一个包，再在包内建立相关你负责的模块的 Service。Service 层相关开发规范上文已叙述，请仔细阅读 base 包内容！

### 5. odd-web
主要存放 Controller 类以及相关配置文件，参考 `GoodController`，请先新建一个包，再在包内建立相关你负责的模块的 Controller。**注意接口返回对象一定是 ResponseBean<> 类型！**

## 5. Git 开发须知
将本项目 Clone 至 IDEA 中后，签出一个新分支即可开始开发，切忌在 `master` 分支上直接进行开发。提交、推送代码后，提一个 `Pull Request` 请求合并至主分支，审核通过并合并后，可以删除你的远程分支。其他成员代码合并后，自己可以先在 IDEA 里面更新一下最新代码噢。

## 6. 最后
大家加油！！！！
