using UnityEngine;

public class MovimentoBase : MonoBehaviour
{
    [Header("movement")]
    [Range(0, 300f)]
    [Tooltip("Quanto velocemente muoversi")]
    [SerializeField] private float speed = 1.0f;
    [Range(0, 300f)]
    [Tooltip("Quanto forte saltare")]
    [SerializeField] private float jumpForce = 1.0f;
    [Header("visuals")]
    [SerializeField] private Color coloreOggetto = Color.red;
    Rigidbody rb;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    bool isGrounded()
    {
        return Physics.Raycast(transform.position, -Vector3.up, 1.05f);
    }

    // Update is called once per frame
    void Update()
    {
        // transform.Translate(0.2f, 0, 0);
        float movimentoH = Input.GetAxis("Horizontal");
        float movimentoV = Input.GetAxis("Vertical");
        // transform.localPosition += Vector3.right * movimentoH * speed + Vector3.forward * movimentoV * speed;
        // rb.AddForce(new Vector3(movimentoH * speed, 0, movimentoV * speed));
        rb.linearVelocity = new Vector3(0, rb.linearVelocity.y, 0); 
        rb.linearVelocity += new Vector3(movimentoH * speed, 0, movimentoV * speed);
        // transform.Translate(Vector3.right * movimentoH * speed + Vector3.forward * movimentoV * speed);

        if (Input.GetKeyDown(KeyCode.Space) && isGrounded())
        {
            rb.AddForce(Vector3.up * jumpForce);
            // rb.AddForce(Vector2.up * jumpForce, ForceMode.Impulse);
        }
    }

    // Applies an upwards force to all rigidbodies that enter the trigger.
    void OnTriggerStay(Collider other)
    {
        /*if (Input.GetKeyDown(KeyCode.Space))
        {
            rb.AddForce(Vector3.up * jumpForce);
            // rb.AddForce(Vector2.up * jumpForce, ForceMode.Impulse);
        }*/
    }

    // elementi principali, caratteristiche c#
    // cos'è unity, cosa fa
    // difference c# java e c# vs resto
    // cos'è ar, caratteristiche principali
    // cos'è component e game object
    // meshrender serve per renderizzare un oggetto
    // rigidbody
}
