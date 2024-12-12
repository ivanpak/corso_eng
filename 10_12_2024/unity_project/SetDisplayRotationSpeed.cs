using UnityEngine;

public class SetDisplayRotationSpeed : MonoBehaviour
{
    [SerializeField]
    DisplayObjectFromCollection d;
    [SerializeField] float maxspeed = 3f;

    public void setSpeed(float s) // s is expected to be between 0 and 1
    {
        d.setRotationSpeed(s * maxspeed);
    }
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        // d = GetComponent<DisplayObjectFromCollection>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
