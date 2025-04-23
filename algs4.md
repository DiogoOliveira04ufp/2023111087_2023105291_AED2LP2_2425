


## Instalação de algs4.jar no repositório local maven


Para instalar a dependência (artefacto) algs4.jar, para o repositorio local maven, execute o comando abaixo:

```sh
./mvnw install:install-file -Dfile=./libs/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar
```
Para executar o comando acima, é necessário abrir um terminal e estar no diretório raiz do projeto.
Em windows use o comando `./mvnw.cmd` e em macos o comando `./mvnw`.

Nota: Pode ter que remover a pasta do repositorio local maven no caso de erro durante a execução devido a erros ou conflitos de versões do JavaFX.
A pasta do repositorio local maven é a pasta .m2 no diretório do usuário.


## Passos genéricos para instalar dependências

Seguem-e os passos para tornar biblioteca algs4 compatível com "java modules"

Consiste em atualizar algs4 para compilar com versão do java mais recente (versão escolhida foi a 17)
Depois importar esse algs4 jar do lado do proj com JavaFX
Em todo o processo usa-se maven dentro do IntelliJ
Nota: comandos maven na tool window no Maven ou no terminal com o wrapper ./mvnw

----
passo 1 - criar jar file compatível com java module "algs4-1.0.0.0.jar"

passo 2 - instalar "algs4-1.0.0.0.jar" no projeto JavaFX desejado

passo 3 - no "module-info.java" do proj JavaFX acrescentar o "requires edu.princeton.cs.algs4;"

----
passo1

-clonar localmente o projeto https://github.com/kevin-wayne/algs4
-acrescentar file "module-info.java" na pasta /src/min/java

"
module edu.princeton.cs.algs4 {
requires java.desktop;
requires java.management;
    exports edu.princeton.cs.algs4;
}
"

-mudar versão do java para 17 em pom.xml (pode usar uma mais recente)
"<java.version>17</java.version>"

-Executar a fase de package do lifecycle maven "./mvnw package" para criar o jar de algs4, isto é, fazer o maven algs4 Lifecycle package

output: "algs4-1.0.0.0.jar" no folder target

----
passo2

- criar folder /libs no projeto JavaFX e copiar para lá "algs4-1.0.0.0.jar"
- Execute Maven Goal
  ./mvnw install:install-file -Dfile=libs/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar

-acrescentar no pom.xml do proj JavaFX a dependência
"
<dependency>
<groupId>edu.princeton.cs</groupId>
<artifactId>algs4</artifactId>
<version>1.0.0</version>
</dependency>
"

----
passo 3

-editar o "module-info.java" do proj JavaFX acrescentar o "requires edu.princeton.cs.algs4;"


## Steps to Setup

Open project folder with IntelliJ

Install and Set JDK 17 (or above):
Open File > Project Structure
Select Platform Settings > SDKs: corretto-17.0.10

Install and Activate JavaFX Plugin and Scene Builder:
Open IntelliJ Settings/Preferences
Plugins: install JavaFX
Languages & Frameworks: JavaFX > set Path to SceneBuilder

Install and Activate Scene Builder (for drawing GUIs):

Execute Maven Goal to create local Maven repository for algs4 lib:
Open Terminal (command line shell)
Execute command:
./mvnw install:install-file -Dfile=libs/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar
Close the project and re-open it with IntelliJ
