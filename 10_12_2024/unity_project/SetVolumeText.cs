using System;
using TMPro;
using UnityEngine;
using UnityEngine.UI;

public class SetVolumeText : MonoBehaviour
{

    private float memorizedVolume;
    private float actualVolume;

    private TextMeshProUGUI t;
    public void updateVolume(float newSliderVal) {
        memorizedVolume = newSliderVal;
        actualVolume = newSliderVal;
        updateVolumeText(actualVolume);
    }

    public void toggleVolume(bool b) {
        if (b == false)
        {
            actualVolume = 0;
        }
        else {
            actualVolume = memorizedVolume;
        }
        updateVolumeText(actualVolume);
    }

    private void updateVolumeText(float vol) {
        Debug.Log("updating volume text to " + vol);
        int val = (int)(vol * 100.0);
        t.text = $"{val}%";
    }
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        t = GetComponent<TextMeshProUGUI>();
    }
}
