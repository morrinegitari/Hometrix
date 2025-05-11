package com.morrine.hometrix.viewmodel

// File: PropertyViewModel.kt
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.morrine.hometrix.model.Property

class PropertyViewModel : ViewModel() {
    // Backing property for the list of properties
    private val _properties = MutableStateFlow<List<Property>>(emptyList())
    val properties: StateFlow<List<Property>> = _properties

    // Function to update the list of properties
    fun setProperties(newProperties: List<Property>) {
        _properties.value = newProperties
    }

    // Function to add a single property
    fun addProperty(property: Property) {
        _properties.value = _properties.value + property
    }

    // Function to remove a property by ID
    fun removePropertyById(propertyId: String) {
        _properties.value = _properties.value.filterNot { it.id == propertyId }
    }
}

