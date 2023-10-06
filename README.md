# TextComponents

A cross-platform way to deal with stylised text

## Current Implementations

- [Spigot](https://github.com/TubMC/TextComponents-Spigot)
- [Paper](https://github.com/TubMC/TextComponents-Fabric)

## Installation

> It is best to use an implementation rather than depending on this as  methods for sending messages will not be accessible

TextComponents is available on Maven from either the [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/text-components) or [JitPack](https://jitpack.io/#TubMC/TextComponents)

### Official Repository

The latest version is hosted on an [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/text-components)

First include the repository:

```xml
<repository>
  <id>bb1-repository-releases</id>
  <name>BradBot_1's Repository</name>
  <url>https://repo.bb1.fun/releases</url>
</repository>
```

Then add the dependency:

```xml
<dependency>
  <groupId>com.tubmc</groupId>
  <artifactId>text-components</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Jitpack

If the official repository is down or you choose not to trust it you can always pull it from [JitPack](https://jitpack.io/#TubMC/TextComponents)

First include the repository:

```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

Then add the dependency:

```xml
<dependency>
  <groupId>com.github.BradBot1</groupId>
  <artifactId>text-components</artifactId>
  <version>LATEST</version>
</dependency>
```

### Local Installation

Just run the following commands:

```shell
git clone https://github.com/TubMC/TextComponents.git
cd TextComponents
mvn clean install
```

It will then be accessible from your [local Maven Repoistory](https://www.javatpoint.com/maven-repository)

Now you can simply add the following dependency without a repository:

```xml
<dependency>
  <groupId>com.tubmc</groupId>
  <artifactId>text-components</artifactId>
  <version>1.0.0</version>
</dependency>
```
