using UnityEngine;
using UnityEngine.SceneManagement;

public class LoadSceneOnTrigger : MonoBehaviour
{

    [SerializeField] string sceneName;

    private void OnTriggerEnter(Collider other)
    {
        if (!string.IsNullOrEmpty(sceneName))
        {
            SceneManager.LoadScene(sceneName);
        }
        else
        {
            Debug.Log("Nome scena non assegnato");
        }
    }
}
