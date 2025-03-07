package plugin.checkversion

import org.gradle.api.Plugin
import org.gradle.api.Project

private const val CHECK_VERSION_CONFIG = "CheckVersionConfig"
private const val CHECK_VERSION_TASK = "checkVersion"

class CheckVersion : Plugin<Project> {
    override fun apply(project: Project) {
        val configName = "${project.name}${CHECK_VERSION_CONFIG}"
        val config = project.extensions.create(configName, CheckVersionConfig::class.java)
        project.tasks.create(CHECK_VERSION_TASK, CheckVersionTask::class.java, config)
    }
}
