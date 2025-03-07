package plugin.checkversion

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

private const val CHECK_VERSION_CONFIG = "CheckVersionConfig"
private const val CHECK_VERSION_TASK = "checkVersion"
private const val ASSEMBLE_TASK = "assemble"

class CheckVersion : Plugin<Project> {
    override fun apply(project: Project) {
        val configName = "${project.name}${CHECK_VERSION_CONFIG}"
        val config = project.extensions.create(configName, CheckVersionConfig::class.java)
        project.tasks.create(CHECK_VERSION_TASK, CheckVersionTask::class.java, config)
//        project.tasks[ASSEMBLE_TASK].dependsOn(CHECK_VERSION_TASK)
    }
}
