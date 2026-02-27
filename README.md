# multi-module-init-archetype

A Maven archetype that generates a pure Maven multi-module project template. It includes the following files:

```
├── .editorconfig
├── .gitattributes
├── .gitignore
├── .mvn
│   └── wrapper
│       └── maven-wrapper.properties
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Usage

```shell
mvn -B archetype:generate \
  -DarchetypeGroupId=io.github.ricardo-z-chao \
  -DarchetypeArtifactId=multi-module-init-archetype \
  -DgroupId=com.example.test \
  -DartifactId=test-project \
  -Dversion=1.0
```

> [!WARNING]
>
> Java version must be 9 or higher.

