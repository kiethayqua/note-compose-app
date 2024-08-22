package com.example.notecompose.presentation.settings.mindmap_view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.notecompose.domain.model.Note
import com.gyso.treeview.adapter.DrawInfo
import com.gyso.treeview.adapter.TreeViewAdapter
import com.gyso.treeview.adapter.TreeViewHolder
import com.gyso.treeview.line.BaseLine
import com.gyso.treeview.line.DashLine
import com.gyso.treeview.model.NodeModel
import com.example.notecompose.databinding.NodeLayoutBinding
import com.example.notecompose.R


class NoteTreeViewAdapter: TreeViewAdapter<Note>() {
    private val dashLine = DashLine(Color.parseColor("#F06292"), 6)
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        model: NodeModel<Note>?
    ): TreeViewHolder<Note> {
        val nodeBinding = NodeLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return TreeViewHolder(nodeBinding.root, model!!)
    }

    override fun onBindViewHolder(holder: TreeViewHolder<Note>) {
        val itemView = holder.view
        val node = holder.node
        val titleView = itemView.findViewById<TextView>(R.id.title)
        val iconView = itemView.findViewById<ImageView>(R.id.icon)
        val note = node.value
        titleView.text = note.title
        iconView.setImageResource(R.drawable.ic_avatar)
    }

    override fun onDrawLine(drawInfo: DrawInfo?): BaseLine? {
        return null
    }
}