using UnityEngine;
using static UnityEditor.Searcher.SearcherWindow.Alignment;

public class script1 : MonoBehaviour
{
    [SerializeField] public float speed = 0;
    [SerializeField] float jumpHeight = 10;
    private Rigidbody rb;
    // rb = GetComponent<Rigidbody>(); \\ From your program
    // rb.position = rb.position + movement* speed * Time.fixedDeltaTime; \\ Instead of MovePosition
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        Debug.Log("Il gioco è iniziato");
        rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {
        // Debug.Log("frame corrente");
        // transform.Translate(new Vector3(1, 0, 0) * Time.deltaTime * speed);
        // transform.Translate(new Vector3(1, 0, 0) * Time.deltaTime * speed);
        float vertical = Input.GetAxis("Vertical");
        float horizontal = Input.GetAxis("Horizontal");
        Debug.Log($"{vertical} {horizontal}");
        Vector3 v1 = rb.linearVelocity;
        v1.Scale(transform.up);
        rb.linearVelocity = v1;
        rb.linearVelocity += (transform.forward * vertical) * speed * Time.fixedDeltaTime;
        rb.linearVelocity += (transform.right * horizontal) * speed * Time.fixedDeltaTime;
        // transform.Rotate((transform.up * horizontal) * rotationSpeed * Time.fixedDeltaTime);

        // float jumpForce = Mathf.Sqrt(jumpHeight * -2 * (Physics2D.gravity.y));

        if (Input.GetKeyDown(KeyCode.Space))
        {
            rb.linearVelocity += (transform.up * jumpHeight);
            // rb.AddForce(Vector2.up * jumpForce, ForceMode.Impulse);
        }
    }
}
