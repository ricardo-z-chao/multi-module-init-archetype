def javaVersion = System.getProperty("java.version")

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
