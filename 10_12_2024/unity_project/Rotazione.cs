using UnityEngine;

public class Rotazione : MonoBehaviour
{

    /*public Rotazione(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }*/

    [SerializeField] public float rotationSpeed = 1.0f;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        // transform.Rotate(0, rotationSpeed, 0);
        Vector3 rotPre = transform.localRotation.eulerAngles;
        transform.localRotation = Quaternion.Euler(rotPre + new Vector3(0, rotationSpeed, 0));
    }
}
