package com.example.userregistraton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.userregistraton.ui.theme.UserRegistratonTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			UserRegistratonTheme {
				Scaffold(
					topBar = { UserRegistrationTopBar() },
					modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					UserRegistration(Modifier.padding(innerPadding))
				}
			}
		}
	}
}

/*
###################################################################
############################ TOP BAR ##############################
###################################################################
 */

@Composable
fun UserRegistrationTextTopBar(modifier: Modifier = Modifier) {
	Text(
		"User Registration",
		maxLines = 1,
		overflow = TextOverflow.Ellipsis,
		modifier = modifier
	)
}

@Composable
fun GoBackIconTopBar(modifier: Modifier = Modifier) {
	IconButton(onClick = { }) {
		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.arrowback),
			contentDescription = null,
			tint = Color.White,
			modifier = modifier
		)
	}
}

@Composable
fun MoreActionsIconTopBar(modifier: Modifier = Modifier) {
	IconButton(onClick = { }) {
		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.more_vert),
			contentDescription = null,
			tint = Color.White,
			modifier = modifier
		)
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationTopBar(modifier: Modifier = Modifier) {
	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

	TopAppBar(
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = Color(0xcf36013f),
			titleContentColor = Color.White
		),
		title = ::UserRegistrationTextTopBar,
		navigationIcon = ::GoBackIconTopBar,
		actions = { MoreActionsIconTopBar() },
		scrollBehavior = scrollBehavior,
		modifier = modifier
	)
}

/*
###################################################################
############################ FULL NAME ############################
###################################################################
 */

@Composable
fun FullNameFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.full_name),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun FullNameFieldIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.person),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun FullNameFieldPlaceholder(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.full_name_placeholder),
		modifier = modifier
	)
}

@Composable
fun FullNameField(modifier: Modifier = Modifier) {
	OutlinedTextField(
		state = rememberTextFieldState(),
		leadingIcon = { FullNameFieldIcon() },
		placeholder = { FullNameFieldPlaceholder() },
		modifier = modifier
	)
}

@Composable
fun FullName(modifier: Modifier = Modifier) {
	Column(modifier) {
		FullNameFieldHeader(Modifier.padding(bottom = 8.dp))
		FullNameField(Modifier.fillMaxWidth())
	}
}

/*
###################################################################
############################## EMAIL ##############################
###################################################################
 */

@Composable
fun EmailFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.email),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun EmailFieldIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.email),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun EmailFieldPlaceholder(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.email_placeholder),
		modifier = modifier
	)
}

@Composable
fun EmailField(modifier: Modifier = Modifier) {
	OutlinedTextField(
		state = rememberTextFieldState(),
		leadingIcon = { EmailFieldIcon() },
		placeholder = { EmailFieldPlaceholder() },
		modifier = modifier
	)
}

@Composable
fun Email(modifier: Modifier = Modifier) {
	Column(modifier) {
		EmailFieldHeader(Modifier.padding(bottom = 8.dp))
		EmailField(Modifier.fillMaxWidth())
	}
}

/*
###################################################################
########################### PASSWORD ##############################
###################################################################
 */

@Composable
fun PasswordFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.password),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun PasswordFieldIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.lock),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun PasswordHideIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.hide),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun PasswordShowIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.show),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun PasswordFieldPlaceholder(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.password_placeholder),
		modifier = modifier
	)
}

@Composable
fun PasswordField(modifier: Modifier = Modifier) {
	val (typedPassword, onPasswordTyped) = remember { mutableStateOf("") }
	var selectedVisibility: Boolean by remember { mutableStateOf(false) }

	OutlinedTextField(
		visualTransformation = if (selectedVisibility) VisualTransformation.None else PasswordVisualTransformation(),
		value = typedPassword,
		onValueChange = onPasswordTyped,
		leadingIcon = {	PasswordFieldIcon() },
		trailingIcon = { IconButton(onClick = {
			selectedVisibility = !selectedVisibility
		}) {
			if (selectedVisibility) {
				PasswordShowIcon()
			} else {
				PasswordHideIcon()
			}
		} },
		placeholder = { PasswordFieldPlaceholder() },
		modifier = modifier
	)
}

@Composable
fun Password(modifier: Modifier = Modifier) {
	Column(modifier) {
		PasswordFieldHeader(Modifier.padding(bottom = 8.dp))
		PasswordField(Modifier.fillMaxWidth())
	}
}

/*
###################################################################
####################### CONFIRM PASSWORD ##########################
###################################################################
 */

@Composable
fun ConfirmPasswordFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.confirm_password),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun ConfirmPasswordFieldPlaceholder(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.confirm_password_placeholder),
		modifier = modifier
	)
}

@Composable
fun ConfirmPasswordField(modifier: Modifier = Modifier) {
	val (typedPassword, onPasswordTyped) = remember { mutableStateOf("") }
	var selectedVisibility: Boolean by remember { mutableStateOf(false) }

	OutlinedTextField(
		visualTransformation = if (selectedVisibility) VisualTransformation.None else PasswordVisualTransformation(),
		value = typedPassword,
		onValueChange = onPasswordTyped,
		leadingIcon = {	PasswordFieldIcon() },
		trailingIcon = { IconButton(onClick = {
			selectedVisibility = !selectedVisibility
		}) {
			if (selectedVisibility) {
				PasswordShowIcon()
			} else {
				PasswordHideIcon()
			}
		} },
		placeholder = { ConfirmPasswordFieldPlaceholder() },
		modifier = modifier
	)
}

@Composable
fun ConfirmPassword(modifier: Modifier = Modifier) {
	Column(modifier) {
		ConfirmPasswordFieldHeader(Modifier.padding(bottom = 8.dp))
		ConfirmPasswordField(Modifier.fillMaxWidth())
	}
}

/*
###################################################################
######################### PHONE NUMBER ############################
###################################################################
 */

@Composable
fun PhoneNumberFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.phone_number),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun PhoneNumberFieldIcon(modifier: Modifier = Modifier) {
	Icon(
		imageVector = ImageVector.vectorResource(R.drawable.call),
		contentDescription = null,
		tint = Color.Black,
		modifier = modifier
	)
}

@Composable
fun PhoneNumberFieldPlaceholder(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.phone_number_placeholder),
		modifier = modifier
	)
}

@Composable
fun PhoneNumberField(modifier: Modifier = Modifier) {
	OutlinedTextField(
		state = rememberTextFieldState(),
		leadingIcon = { PhoneNumberFieldIcon() },
		placeholder = { PhoneNumberFieldPlaceholder() },
		modifier = modifier
	)
}

@Composable
fun PhoneNumber(modifier: Modifier = Modifier) {
	Column(modifier) {
		PhoneNumberFieldHeader(Modifier.padding(bottom = 8.dp))
		PhoneNumberField(Modifier.fillMaxWidth())
	}
}

/*
###################################################################
############################ GENDER ###############################
###################################################################
 */

@Composable
fun GenderFieldHeader(modifier: Modifier = Modifier) {
	Text(
		text = stringResource(R.string.gender),
		fontWeight = FontWeight.Bold,
		modifier = modifier
	)
}

@Composable
fun GenderRadioButtons(modifier: Modifier = Modifier) {
	val radioOptions = listOf("Male", "Female", "Other")
	val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

	FlowRow(modifier.selectableGroup()) {
		radioOptions.forEach { text ->
			Row (
				Modifier
					.height(56.dp)
					.selectable(
						selected = (text == selectedOption),
						onClick = { onOptionSelected(text) },
						role = Role.RadioButton
					)
					.padding(horizontal = 16.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				RadioButton(
					selected = (text == selectedOption),
					onClick = null
				)
				Text(
					text = text,
					style = MaterialTheme.typography.bodyLarge,
					modifier = Modifier.padding(start = 16.dp)
				)
			}
		}
	}
}

@Composable
fun Gender(modifier: Modifier = Modifier) {
	Column(modifier) {
		GenderFieldHeader(Modifier.padding(bottom = 8.dp))
		GenderRadioButtons()
	}
}

/*
###################################################################
########################### REGISTER ##############################
###################################################################
 */
@Composable
fun RegisterButton(modifier: Modifier = Modifier) {
	Button(
		onClick = { },
		colors = ButtonDefaults.buttonColors(
			containerColor = Color(0xcf36013f),
			contentColor = Color.White
		),
		modifier = modifier,
		shape = RoundedCornerShape(2.dp)
	) {
		Text(
			text = "REGISTER",
			textAlign = TextAlign.Center
		)
	}
}

@Composable
fun UserRegistration(modifier: Modifier = Modifier) {
	Column(modifier = modifier
		.padding(start = 32.dp, end = 32.dp, top = 20.dp)
		.verticalScroll(rememberScrollState())
	) {
		FullName(Modifier.padding(bottom = 16.dp))
		Email(Modifier.padding(bottom = 16.dp))
		Password(Modifier.padding(bottom = 16.dp))
		ConfirmPassword(Modifier.padding(bottom = 16.dp))
		PhoneNumber(Modifier.padding(bottom = 16.dp))
		Gender(Modifier.padding(bottom = 24.dp))
		RegisterButton(Modifier.fillMaxWidth())
	}
}