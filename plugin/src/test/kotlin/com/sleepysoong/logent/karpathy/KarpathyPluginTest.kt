package com.sleepysoong.logent.karpathy

import java.nio.file.Files
import java.nio.file.Path
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/** karpathy 지침 스킬 하나와 upstream 본문 자산을 확인해요. */
class KarpathyPluginTest {
    private val assets: Path = Path.of(
        requireNotNull(System.getProperty("logent.plugin.assets")) { "logent.plugin.assets가 필요해요." },
    )

    @Test
    fun `플러그인은 karpathy 지침 스킬 하나만 노출한다`() {
        val plugin = KarpathyPlugin()
        assertEquals("com.sleepysoong.logent.karpathy", plugin.id)
        assertEquals("Karpathy Guidelines", plugin.name)
        assertEquals(BuildConfig.PLUGIN_VERSION, plugin.version)
        assertEquals(4, plugin.apiVersion)

        val skills = plugin.skills()
        assertEquals(1, skills.size)
        assertEquals("karpathy-guidelines", skills.single().name)
        assertEquals("plugins/karpathy/SKILL.md", skills.single().assetPath)
        assertTrue(skills.single().promptIndex)
    }

    @Test
    fun `upstream 원본 본문을 자산으로 포함한다`() {
        val body = Files.readString(assets.resolve("plugins/karpathy/SKILL.md"))
        assertTrue(body.startsWith("---\nname: karpathy-guidelines"))
        assertTrue(body.contains("# Karpathy Guidelines"))

        val upstreamRoot = Path.of(
            requireNotNull(System.getProperty("logent.upstream.root")) { "logent.upstream.root가 필요해요." },
        )
        val upstream = Files.readString(upstreamRoot.resolve("skills/karpathy-guidelines/SKILL.md"))
        assertEquals(upstream, body)
    }
}
