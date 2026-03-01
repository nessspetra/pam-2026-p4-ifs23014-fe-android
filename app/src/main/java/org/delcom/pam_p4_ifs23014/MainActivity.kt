package org.delcom.pam_p4_ifs23014

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.delcom.pam_p4_ifs23014.ui.UIApp
import org.delcom.pam_p4_ifs23014.ui.theme.DelcomTheme
import org.delcom.pam_p4_ifs23014.ui.viewmodels.FoodViewModel // Import FoodViewModel
import org.delcom.pam_p4_ifs23014.ui.viewmodels.PlantViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val plantViewModel: PlantViewModel by viewModels()
    private val foodViewModel: FoodViewModel by viewModels() // Inisialisasi FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DelcomTheme {
                UIApp(
                    plantViewModel = plantViewModel,
                    foodViewModel = foodViewModel
                )
            }
        }
    }
}