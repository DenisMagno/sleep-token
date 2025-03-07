package plugin.checkversion

abstract class CheckVersionConfig {
    abstract var version: String
    abstract var ignore: List<String>
}