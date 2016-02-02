#### Scala代码覆盖率
1. Maven与Sonar结合出Scala代码覆盖率

#### Maven集成Sonar
修改maven的主配置文件（${MAVEN_HOME}/conf/settings.xml文件或者 ~/.m2/settings.xml文件），在其中增加访问Sonar数据库及Sonar服务地址，添加如下配置：
```
<profile>

<id>sonar</id>

<properties>

    <sonar.jdbc.url>jdbc:mysql://localhost:3306/sonar</sonar.jdbc.url>

    <sonar.jdbc.driver>com.mysql.jdbc.Driver</sonar.jdbc.driver>

    <sonar.jdbc.username>sonar</sonar.jdbc.username>

    <sonar.jdbc.password>sonar</sonar.jdbc.password>

    <sonar.host.url>http://localhost:9000</sonar.host.url> <!-- Sonar服务器访问地址 -->

</properties>

</profile>

<activeProfiles>

  <activeProfile>sonar</activeProfile>

</activeProfiles>
```

#### Scoverage plugin for Sonar

> https://github.com/RadoBuransky/sonar-scoverage-plugin/releases

```
   # 下载相应的插件,并拷贝到sonar插件目录,然后重启sonar即可
   cp sonar-scoverage-plugin-*.jar sonarqube/extensions/plugins/
```

#### Maven运行
```
mvn clean scoverage:report sonar:sonar
```

#### 相关资料

> http://scoverage.github.io/scoverage-maven-plugin/1.1.1/plugin-info.html
>
> https://github.com/RadoBuransky/sonar-scoverage-plugin
>
> https://github.com/scoverage/scoverage-maven-plugin

#### 帮助
在运行```mvn clean scoverage:report sonar:sonar```出现sonar错误时,按照sonar提示,打开地址(localhost:9000/api/qualityprofiles/search.protobuf?projectKey=...)有相应的错误信息,如果是出现的错误是```No quality profile can been found on language 'scala' for project```,可以按照如下解决:

1. 在sonar安装sonar-scalastyle插件
2. 重启sonar
3. 再删除sonar-scalastyle插件
4. 重启sonar
5. 解决(这个问题估计是sonar-scoverage-plugin的一个小Bug,遗漏了部分配置,刚好sonar-scalastyle有该配置,注意两个插件不能同时存在,不然会有冲突)

> sonar-scalastyle插件地址 https://github.com/emrehan/sonar-scalastyle/