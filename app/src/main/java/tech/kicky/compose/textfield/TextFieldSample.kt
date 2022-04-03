package tech.kicky.compose.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import tech.kicky.compose.text.SectionTitle


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextFieldSamples() {
    LazyColumn {
        stickyHeader {
            SectionTitle(title = "TextField")
        }
        item {
            SimpleTextFieldSample()
            SimpleOutlinedTextFieldSample()
            TextFieldWithIcons()
            TextFieldWithPlaceholder()
            TextFieldWithErrorState()
            TextFieldWithHelperMessage()
            PasswordTextField()
            TextFieldSample()
            OutlinedTextFieldSample()
            TextFieldWithHideKeyboardOnImeAction()
            TextArea()
        }
    }
}