#!/usr/bin/env bash
# upstream 원본 SKILL.md를 플러그인 자산으로 동기화해요. 원본은 수정하지 않아요.
set -euo pipefail
cd "$(dirname "$0")/.."
install -D -m 0644 skills/karpathy-guidelines/SKILL.md \
    plugin/src/main/assets/plugins/karpathy/SKILL.md
printf 'karpathy 자산을 동기화했어요.\n'
