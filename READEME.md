### cdn大数据实时日志分析
 ##### 项目主要特点  前后端分离
  * 后端采用SSM框架开发，tomcat作为后端服务器+nginx作为代理服务器+redis作为二级缓存 + ajax JSON 数据响应
  * 前端使用vue布局 + js事件处理 
### 开发工具  
  + 前端使用VSCode,后端使用idea。当然后端可以打包成war包，把war包放进tomcat的webapps目录下，然后按照图片步骤可以部署服务器（为保证tomcat服务器可正常访问，需先启动运行redis）,觉得配置环境变量麻烦也可以直接再tomcat/bin下直接点击运行startup.bat启动服务器部署项目;    

### 前后端分离的主要原理  
 1. 用户通过访问url，监听该url端口的代理服务器会对请求拦截；然后判断是否是对vue网页资源请求，是的话就由代理服务器进行登录页等相关页面响应。若为ajax等动态数据获取请求，代理服务器会转发给后端tomcat服务器进行数据响应。

 ###  优点:
 * nginx高并发连接，稳定，动静分离，集群，负载均衡  
 * redis缓存，减少数据访问次数，提高性能

