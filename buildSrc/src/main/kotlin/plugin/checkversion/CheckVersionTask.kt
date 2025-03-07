package plugin.checkversion

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

abstract class CheckVersionTask @Inject constructor(private val config: CheckVersionConfig) :
    DefaultTask() {

    companion object {
        private const val VERSION_REFERENCE = "_version_"
        private const val REGEX_MATCH_CHANGELOG_VERSION = "^##.*($VERSION_REFERENCE)"
        private const val REGEX_MATCH_BADGE_VERSION =
            "(Latest version $VERSION_REFERENCE).*(latest--version-$VERSION_REFERENCE)"

        private const val CHANGELOG_FILE_NAME = "CHANGELOG.md"
        private const val README_FILE_NAME = "README.md"
    }

    @TaskAction
    fun checkChangelog() {
        config.ignore.forEach { if (config.version.contains(it)) return }

        val file = project.file("${project.rootDir}${File.separatorChar}$CHANGELOG_FILE_NAME")

        val lines = file.readLines()
        lines.forEach {
            val regex = Regex(REGEX_MATCH_CHANGELOG_VERSION).replaceVersion(config.version)

            regex.find(it)?.let {
                return
            }
        }

        throw GradleException("Changelog for version ${config.version} NOT FOUND in $CHANGELOG_FILE_NAME")
    }

    @TaskAction
    fun checkBadge() {
        config.ignore.forEach { if (config.version.contains(it)) return }

        val file = project.file("${project.rootDir}${File.separatorChar}$README_FILE_NAME")

        val lines = file.readLines()
        lines.forEach {
            val regex = Regex(REGEX_MATCH_BADGE_VERSION).replaceVersion(config.version)

            regex.find(it)?.let {
                return
            }
        }

        throw GradleException("Badge for version ${config.version} NOT FOUND in $README_FILE_NAME")
    }

    private fun Regex.replaceVersion(version: String) =
        Regex(this.pattern.replace(VERSION_REFERENCE, version))
}