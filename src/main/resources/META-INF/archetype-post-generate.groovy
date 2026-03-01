def javaVersion = request.getProperties().getProperty("java.version", System.getProperty("java.version"))

def versionParts = javaVersion.split(/[.\-_]/)
def majorVersion

if (versionParts[0] == "1" && versionParts.length > 1) {
  majorVersion = Integer.parseInt(versionParts[1])
} else {
  majorVersion = Integer.parseInt(versionParts[0])
}

if (majorVersion < 9) {
  throw new IllegalArgumentException("Java version must be 9 or higher, got: ${javaVersion}")
}

def outputDir = new File(request.outputDirectory, request.artifactId)

def pomFile = new File(outputDir, 'pom.xml')
def pomContent = pomFile.text
pomContent = pomContent.replace('${majorVersion}', majorVersion.toString())
pomFile.text = pomContent

def renamedFiles = [
  'editorconfig.src' : '.editorconfig',
  'gitattributes.src': '.gitattributes',
  'gitignore.src'    : '.gitignore'
]

renamedFiles.each { src, dest ->
  def srcFile = new File(outputDir, src)
  def destFile = new File(outputDir, dest)
  if (srcFile.exists()) {
    srcFile.renameTo(destFile)
  }
}

new File(outputDir, 'mvnw').setExecutable(true)
new File(outputDir, 'mvnw.cmd').setExecutable(true)
