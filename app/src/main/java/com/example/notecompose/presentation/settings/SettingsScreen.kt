package com.example.notecompose.presentation.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.notecompose.databinding.MindmapViewBinding
import com.example.notecompose.domain.model.Note
import com.example.notecompose.presentation.settings.mindmap_view.NoteTreeViewAdapter
import com.gyso.treeview.layout.RightTreeLayoutManager
import com.gyso.treeview.line.SmoothLine
import com.gyso.treeview.model.NodeModel
import com.gyso.treeview.model.TreeModel

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val context = LocalContext.current

        AndroidViewBinding(factory = MindmapViewBinding::inflate) {
            val adapter = NoteTreeViewAdapter()
            val treeLayoutManager = RightTreeLayoutManager(context, 30, 20, SmoothLine())
            baseTreeView.apply {
                setAdapter(adapter)
                setTreeLayoutManager(treeLayoutManager)
            }
            val fakeData = fakeNodeData()
            adapter.treeModel = fakeData
        }
    }
}

fun fakeNodeData(): TreeModel<Note> {
    val root = NodeModel(Note(
        title = "Test1",
        content = "Test1",
        color = -1,
        timestamp = System.currentTimeMillis()
    ))
    val treeModel = TreeModel(root)

    val child1 = NodeModel(Note(
        title = "Test2",
        content = "Test2",
        color = -1,
        timestamp = System.currentTimeMillis()
    ))
    val child2 = NodeModel(Note(
        title = "Test3",
        content = "Test3",
        color = -1,
        timestamp = System.currentTimeMillis()
    ))

    treeModel.addNode(root, child1, child2)

    return treeModel
}