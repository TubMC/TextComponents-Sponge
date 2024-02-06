# TextComponents [Sponge8 Edition]

A simple [TextComponents](https://github.com/TubMC/TextComponents) implementation that provides support for Sponge

> Most of the heavy lifting is provided by the [Adventure Implementation](https://github.com/TubMC/TextComponents-Adventure/tree/master)! For more general documentation go there


## Implementation Specific Methods

> This does not include methods provided by the [Adventure Implementation](https://github.com/TubMC/TextComponents-Adventure/tree/master)

The following methods are added to all IComponents in this implementation:

| Name     | Parameters    | Return Type   | Function                                          |
|----------|---------------|---------------|---------------------------------------------------|
|sendToAll|||Sends the message to all players and displays it inside of the console|
|log|||Displays the component to the console only|
|sendToAllWithPermission|String||Sends the component to all players with the provided permission|

## Installation

TextComponents is available on Maven from either the [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/text-components-sponge8) or [JitPack](https://jitpack.io/#TubMC/TextComponents-Sponge)

### Official Repository

The latest version is hosted on an [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/text-components-sponge8)

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
  <artifactId>text-components-sponge8</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Jitpack

If the official repository is down or you choose not to trust it you can always pull it from [JitPack](https://jitpack.io/#TubMC/TextComponents-Sponge)

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
  <artifactId>text-components-sponge8</artifactId>
  <version>LATEST</version>
</dependency>
```

### Local Installation

Just run the following commands:

```shell
git clone https://github.com/TubMC/TextComponents-Sponge.git
cd TextComponents-Sponge
git checkout origin sponge8
mvn clean install
```

It will then be accessible from your [local Maven Repoistory](https://www.javatpoint.com/maven-repository)

Now you can simply add the following dependency without a repository:

```xml
<dependency>
  <groupId>com.tubmc</groupId>
  <artifactId>text-components-sponge8</artifactId>
  <version>1.0.0</version>
</dependency>
```