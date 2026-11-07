package com.sleepysoong.logent.karpathy

import com.sleepysoong.logent.plugin.LogentPlugin
import com.sleepysoong.logent.plugin.PluginSkill

/**
 * Andrej Karpathy의 코딩 지침 스킬 하나만 제공해요.
 *
 * 본문은 upstream `skills/karpathy-guidelines/SKILL.md`를 빌드 때 자산으로 모아
 * Termux 없이 읽어요.
 */
class KarpathyPlugin : LogentPlugin {
    override val id: String = "com.sleepysoong.logent.karpathy"
    override val name: String = "Karpathy Guidelines"
    override val version: String = BuildConfig.PLUGIN_VERSION

    override fun skills(): List<PluginSkill> = listOf(
        PluginSkill(
            name = "karpathy-guidelines",
            description = "코딩 실수를 줄이는 사고·단순함·국소 변경·검증 가능한 목표 지침이에요.",
            assetPath = "plugins/karpathy/SKILL.md",
        ),
    )
}
