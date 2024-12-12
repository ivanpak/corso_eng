using UnityEngine;

public class SetCameraPosition : MonoBehaviour
{

    [Range(0.0f,1.0f)]
    public float pos;
    [SerializeField]
    Vector3 end1;
    [SerializeField]
    Vector3 end2;
    [SerializeField]
    Vector3 rot1;
    [SerializeField]
    Vector3 rot2;

    public void setPosition(float f) {
        pos = f;
    }
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        transform.localPosition = end1 * (1 - pos) + end2 * pos;
        transform.localRotation = Quaternion.Euler(rot1 * (1 - pos) + rot2 * pos);
    }
}
