# Karpathy Guidelines Logent 플러그인

Andrej Karpathy의 코딩 지침 스킬 하나를 Logent에 제공하는 동적 플러그인이에요.
원본 저장소 [multica-ai/andrej-karpathy-skills](https://github.com/multica-ai/andrej-karpathy-skills)를
포크해 `logent` 브랜치에 플러그인 패키징을 얹었어요.

- 플러그인 ID: `com.sleepysoong.logent.karpathy`
- 스킬: `karpathy-guidelines`
- 본문: upstream `skills/karpathy-guidelines/SKILL.md`를 빌드 때 `plugins/karpathy/SKILL.md`로 모아요.
- Termux 없이 자산에서 읽어요.

`logent-plugin.json`을 `scripts/plugin-pack.py build --definition logent-plugin.json`의
공통 정의로 사용해요. 플러그인 key는 `sleepysoong:karpathy`, `dependencies`는 `[]`예요.
`sleepysoong`는 명시한 publisher 별칭이며 GitHub 인증 계정이나 소유권을 뜻하지 않아요.
key와 의존성에서 생성한 manifest의 `requires`가 `.lpg`에 함께 들어가요.

## 자산 동기화

upstream `skills/karpathy-guidelines/SKILL.md`를 바꾼 뒤에는 아래 명령으로 플러그인 자산을 갱신해요.
테스트가 자산과 upstream 본문이 같은지 확인해요.

```bash
./scripts/sync-assets.sh
```

## 빌드

```bash
./scripts/build.sh -PlogentPluginApiMavenLocal=true
```

`build/dist/<name>-v<version>.lpg` 하나가 생겨요.

릴리스는 `./scripts/release.sh 1.0.1 'English summary' '한국어 해요체 본문'`으로 수행해요.
`main`·`logent` 커밋마다 `.github/workflows/plugin-edge.yml`이 `.lpg`를 `edge`에 올려요.

원본 README는 [`README.upstream.md`](README.upstream.md), 출처·변경 내역은 [`NOTICE`](NOTICE),
고정한 upstream 커밋은 [`UPSTREAM_COMMIT`](UPSTREAM_COMMIT)에 있어요.
