package tech.kicky.compose.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import tech.kicky.compose.text.SectionTitle


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextFieldSamples() {
    LazyColumn {
        // Text Field 基础使用
        stickyHeader {
            SectionTitle(title = "TextFiled")
        }
        item {
            SimpleTextFieldSample()
        }

        // OutlinedTextField 基础使用
        stickyHeader {
            SectionTitle(title = "OutlinedTextField")
        }
        item {
            SimpleOutlinedTextFieldSample()
        }

        // 带图标
        stickyHeader {
            SectionTitle(title = "Icons")
        }
        item {
            TextFieldWithIcons()
        }

        // 带占位文本
        stickyHeader {
            SectionTitle(title = "Placeholder")
        }
        item {
            TextFieldWithPlaceholder()
        }

        // 错误状态
        stickyHeader {
            SectionTitle(title = "Error State")
        }
        item {
            TextFieldWithErrorState()
        }

        // 密码
        stickyHeader {
            SectionTitle(title = "Password")
        }
        item {
            PasswordTextField()
        }

        // keyboard Options
        stickyHeader {
            SectionTitle(title = "Keyboard Options")
        }
        item {
            TextFieldWithHideKeyboardOnImeAction()
        }

    }
}