using System.Collections.Generic;
using UnityEngine;

public class DisplayObjectFromCollection : MonoBehaviour
{

    [SerializeField]
    List<GameObject> objects;

    [SerializeField] float rotationSpeed = 2.0f;


    public void setRotationSpeed(float s) {
        rotationSpeed = s;
        foreach (GameObject obj in objects)
        {
            if (obj.activeSelf)
            {
                Rotazione rotComp = obj.GetComponent<Rotazione>();
                rotComp.rotationSpeed = rotationSpeed;
            }
        }
    }


    public void showObject(string name) {
        foreach (GameObject obj in objects) {
            if (obj.name == name)
            {
                obj.SetActive(true);
                Rotazione rot1 = obj.AddComponent < Rotazione > ();
                rot1.rotationSpeed = rotationSpeed;
            }
            else {
                obj.SetActive(false);
                Rotazione rotRem = obj.GetComponent<Rotazione>();
                Destroy(rotRem);
            }
        }
    }
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        foreach (GameObject obj in objects)
        {
            obj.SetActive(false);
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
