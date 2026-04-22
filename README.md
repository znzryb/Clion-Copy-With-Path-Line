# Copy with Absolute Path and Lines

一个给 **CLion / IntelliJ / PyCharm** 等所有 JetBrains IDE 用的小插件。复制选中的代码时，自动在开头加一行"绝对路径 + 行号区间"的注释，方便把代码贴给 Claude / ChatGPT 时，让 AI 一眼知道这段代码来自哪个文件的哪几行。

## 安装

1. 从 [Releases](https://github.com/znzryb/Clion-Copy-With-Path-Line/releases/tag/v1.0.0) 下载 `CopyWithAbsolutePath-1.0.0.zip`
2. 打开 IDE → `Settings / Preferences` → `Plugins` → 右上角齿轮图标 → **Install Plugin from Disk…**
3. 选择刚才下载的 zip
4. 重启 IDE

## 使用

1. 在编辑器里**选中一段代码**（没有选中时菜单项不会出现）
2. **右键** → 菜单里找到 **"Copy with Absolute Path and Lines"**（在 `Copy Reference` 下面）
3. 点一下，剪贴板里就是：

```
// /Users/you/project/src/main.cpp:42-50
int solve(int n) {
    ...
}
```

- 选一行 → 头部是 `path:42`
- 选多行 → 头部是 `path:42-50`

## 绑快捷键（可选）

`Settings → Keymap`，搜索 **"Copy with Absolute Path and Lines"**，右键 `Add Keyboard Shortcut`，分配一个顺手的组合键（比如 `⌥⇧C`）。

## 从源码构建

```bash
./gradlew buildPlugin
```

产物在 `build/distributions/CopyWithAbsolutePath-<version>.zip`。
